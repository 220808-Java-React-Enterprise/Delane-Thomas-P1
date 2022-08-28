# Develpment documentation delane-branch.

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