# Development documentation delane-branch.

### August 25th Day 1;
- Reviewed project details.
- Project repository created by partner (Thomas G.)
- Repository cloned and delane-branch created. 
- began installation and setup of needed systems. (tomcat version 9.0.65) 

### August 26th Day 2;
- Operation of tomcat changed from docker hosted to local client installation, for easier connection to AWS DB.
- created AWS RDS & connected it to postgreSQL running on docker.
- Had some problems with AWS-postgreSQL connection timing out. > Solved by adding a postgres rule to the default security group. 
- Project folder converted to maven project stucture & java 8 language.
- *Added;*
  - Directories: 
    - reimbursement-api
    - daos
    - dtos
    - services
    - util
    - customexcemtions
    - webapps
    - WEB-INF
    - test directories for the ones listed.
  - Files:
    - web.xml
    - index.html 

### August 27th Day 3;
- Research on db connection.
- updated gitignore to include;
  - *.properties
  - *.idea/
  - *.target/
  - *.iml
  - *.out/
- Created the database following the provided ERD.
- Problems with two of the types listed(number and blob), they are not known/used by postgres. Alternatives found(money, bytea).
- Met with partner decided work division for the day.
- Changed the name of reimbursement-api to reimbursementapi. The first caused java classes to not be creatable in the package. 
- Filled in datafields, constructors, and get/set methods for distributed model classes. 
- Edited the pom.xml file. Filled in missing dependencies and removed incorrect dependency.
- Edited db.properties added aws url. 
- *Added;*
  - Directories:
    - models 
    - database 
  - Files:
    - db.properties
    - Doc.md
    - DBConnection
    - ERS_Reimbursements
    - ERS_Reimbursements_types
    - ERS_Reimbursements_statuses
    - ERS_ReimbursementsService
    - ERS_Reimbursements_typesService
    - ERS_Reimbursements_statusesService 

### August 28th Day 4
- Replaced DBCOnnection with ConnectionFactory to save time. Will try again if time permits.
- Met partner scheduled meeting for next day.
- Continued work on reimbursement service and DAO.
- Started work on reimbursement type. 
- Changed reimb-id, author-id, and resolver-id types to UUID. 
- Committed and pushed to my branch. 
- *Added;*
  - Directories:
    -servlets 
  - Files:
    - PlaceHolderException
    - TestServlet 

### August 29th Day 5
- Met with partner merged branch to main.
- Started looking into connections.
- Received error when trying to deploy project.  Looking into it.
  - [ERROR] Failed to execute goal org.apache.maven.plugins:maven-war-plugin:2.2:war (default-war) on project Delane-Thomas-P1: Error assembling WAR: webxml attribute is required (or pre-existing WEB-INF/web.xml if executing in update mode) -> [Help 1]
- Error solved changed webapps to webapp. The default folder could not be found due to the misspelling.
- Problem logging into localhost:8080 manager, name and password not accepted, Working on it.

### August 30th Day 6 
- Still working on http login problem. tried using maven-tomcat username received a 403 error. SOLVED realized I used the wrong username at first. (I used the DB username not the websever username.)
- Added *.DS_Store to gitignore.
- Changed groupid in the pom.xml file to com.revature
- $CATALINA_HOME\bin\catalina.sh run command not working for me. Looking into it.
- Committed and pushed to my branch to create a bkp while looking into catalina run command. (Resolved thanks to partner input, used the startup.bat file with windows cmd start)
- Edited ContextLoadListener, added first test servlet and checked connection.
- Created NewReimbursementRequest in dto request. Tested in postman with a simplified post request. Test successful can move on to other verbs. 
- Attempted DB connection with post request, data not persisting, data not being written to DB. Looking into it. 
- *Added;*
  - Directories:
  - Files:
    - ContextLoadListener
    - ReimbursementServlet 
    - NewReimbursementRequest 
    - Reimbursement request bodies (Not pushed just a local back up.)  
- *Removed;*
  - Files:
    - TestServlet (Basic servlet test complete no longer needed.) 
 