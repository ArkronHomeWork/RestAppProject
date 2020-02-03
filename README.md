### RestAppProject
***
RESTService realizing CRUD for polls
#####  Quick start
***
To migrate DB at the first start and make service independently create the necessary objects in the database using 
Liquibase you should copy db.changelog-master.yaml to your project and name your DB "resttest". 
The rest Liquibase will do instead of you :) <br> **Please note** that yaml is very sensitive and one extra space when 
further changing this file may cause database initialization errors.
 
 ##### Documentation
 ***
 If you will have any issues with Liquibase [here](https://www.liquibase.org/documentation/index.html) you can find 
 all of the solutions.
 