create index IX_543507A7 on Student_Events (groupId);
create index IX_12C3FB97 on Student_Events (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_57747BD9 on Student_Events (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D30C32AF on Student_Student (email[$COLUMN_LENGTH:75$]);
create index IX_6A11EF4D on Student_Student (groupId);
create index IX_811A4EB1 on Student_Student (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BD98CD73 on Student_Student (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6970C7C7 on Student_events (groupId);
create index IX_4DEE5F77 on Student_events (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D7A657B9 on Student_events (uuid_[$COLUMN_LENGTH:75$], groupId);