# University Admission Counseling Webapp

 This is a (re)construct of an acadmic project I did in university.

### What is it
- This webapp tries to simplify counseling process of getting admission at universities and colleges for students.
- For a teacher/admin one can increase/decrease number of seats in an institution.
- Please note cutoff marks are fixed (even for admin) as they are set by institutions and shouldn't be changed, at least for a given admission round.

### How it works
One could either register (& login) as a student for counseling process, where an examination rank based on an imaginary entrance exam (for demonstration purpose) will be randomly assigned OR as an admin/teacher where they could manipulate number of seats in an institution for any branch/course.

### Highlights
- Simple registration & login.
- Authentication & Authorization i.e. a student cannot access teachers/admins page and vice versa.
- Hibernate and JDBC for database.
- JSP and some CSS for frontend.
- Spring MVC as The Framework for app as whole.
- Maven based so it can be extended further in terms of functionality and be  easily ported to any other IDE.

### Tools required
| Program | Version |
| ----------| ---------|
| JDK | 8 |
| MySQL community | 8.0 |
| Eclipse (+Maven) |  2020-06 |
| Apache Tomcat |  9.0 |

### How to set it up
1. Install and setup all requirements mentioned above. (Eclipse isn't a necessity, any maven based IDE should work).
2. Run database script `createDB.sql` in sql-scripts directory.
3. Open `hibernate-mysql.properties` file in src/main/resources/ and edit it with your databse credentials.
4. Import project in Eclipse as Maven Project.
5. Select project from project explorer and right click -> Run As -> Run on Server.

### Libraries used
- Spring Web MVC
- Hibernate
- MySQL & JDBC
- Java Servlets
- JSP & JSTL