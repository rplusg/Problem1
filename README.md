# background
- This is my first java program after college, i.e. after 14 years :-)

- Total time taken is, slightly less than 4 hours including setting up java, h2, eclipse etc.

- I've not included unit tests due to lack of knowledge around syntax.

# solution overview
- Please use run.bat "employeeserv-master\run.bat" or "employeeserv-master\employeeservImplementation\run.bat" to run this project.

REST Access points:

- Get: http://localhost:8080/v1/bfs/employees/20

- POST: http://localhost:8080/v1/bfs/employees

    POST BODY: {
                "id": "20",
                "first_name": "firstName1",
                "last_name": "lastName1",
                "dob": "dob1",
                "address": {
                  "line1":"line1",
                  "line2":"line2",
                  "city":"bangalore",
                  "state":"state",
                  "country":"country",
                  "zipCode":"zipCode"
                }
              }

- Added PRIMARY KEY during insert on id, feel free to remove it.

- I couldnt use H2 ORM with models, as they are generated on the fly from jsons. Otherwise using with annotations would be easy to solve. 

- Currently i'm firing queries from DAO. And this can be easily replaced with ORM.

- Couldnt cover all corner case validations, happy paths covered.

- LLD is pretty extensible based on need. for ex: EmployeeH2DAO can be replaced withh EmployeeOracleDAO without much of fuss.

- Implemented only POST and GET but given skeletons for all CRUD operations, designed interfaces for search as well.

