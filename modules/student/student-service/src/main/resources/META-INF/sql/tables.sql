create table Student_Events (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventName VARCHAR(75) null,
	eventDescription VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null
);

create table Student_Student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	age INTEGER,
	email VARCHAR(75) null,
	assignment_status VARCHAR(75) null
);

create table Student_events (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventName VARCHAR(75) null,
	eventDescription VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null
);