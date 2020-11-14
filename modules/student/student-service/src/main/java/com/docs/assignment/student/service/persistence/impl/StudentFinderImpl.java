package com.docs.assignment.student.service.persistence.impl;

import com.docs.assignment.student.model.Student;
import com.docs.assignment.student.model.impl.StudentImpl;
import com.docs.assignment.student.service.persistence.StudentFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = StudentFinder.class)
public class StudentFinderImpl extends StudentFinderBaseImpl
implements StudentFinder{
	
	@Reference(service = CustomSQL.class) 
	private CustomSQL _customSql ;
	
	
		public List<Student> findByUsernameEmail(
			    String userName, String email) {

			    Session session = null;
			    try {
			        session = openSession();

			        String sql = _customSql.get(
			            getClass(), FIND_BY_USERNAME_EMAIL);

			        SQLQuery q = session.createSQLQuery(sql);
			        q.addEntity("Student", StudentImpl.class);

			        QueryPos qPos = QueryPos.getInstance(q);
			        qPos.add(userName);
			        qPos.add(email);
			        

			        return (List<Student>) q.list();
			    }
			    catch (Exception e) {
			        e.printStackTrace();
			    }
			    finally {
			        closeSession(session);
			    }

			    return null;
			}


	public List<Student> findByName(String name){

		Session session = null;
		try {
			session = openSession();

			String sql = _customSql.get(
					getClass(), FIND_BY_NAME);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Student", StudentImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(name);
			return (List<Student>) q.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeSession(session);
		}

		return null;
	}

	public static final String FIND_BY_NAME=
					StudentFinder.class.getName() +
							".findByName";
	public static final String FIND_BY_USERNAME_EMAIL=
			StudentFinder.class.getName() +
					".findByUsernameEmail";

}
