# parking_management

SETUP

1)In this Project i have using spring Boot,mysql,jpa repository

2)After successfully Cloning the Project you can Create database with a name parking_db

3)edit the application.properties file
  
  spring.datasource.url={port of your database}/parking_db
  
  spring.datasource.username={databse username}
  
  spring.datasource.password={database password}

4)run the project as spring Boot app

5)After running the project you can call the api by using postman collection.
 
 DESIGN
 
 1)There is 3 different Lot entity for 3 different Lot Size
 
 2)when running the application first time, one parking lot for each size will be created by using CommandLineRunner
 
 3)configuring the number of parkng lot-:
 
    by calling api '/api/lotDetails/addLot' we can add lot one by one. 
    It Required a String parameter 'lotType' which can have value small,medium,large 
    if the api is called with the parameter value 'small' one more lot will be available for small size lot table
    by calling api '/api/lotDetails/deletLot' we can delete particular lot
    it required  String parameter 'lotType' and long parameter 'lotId'
    the lot with the givenn id in particular size will be deleted
 
 4)Getting all lotdetails-:
 
    the api for getting all lot is '/api/lotDetails/getAllLot'
    it gives all sized lot information
 
 5)Getting only Slot which is suitable for car size-:
 
     the api is /api/lotDetails/getLotByType
     the parameters are width and length of the car
     it gives  list of  Lot which is only accessible by given sized car
 
 6)Lot booking-:
 
     the api is /api/lotDetails/lotBooking 
      It Required a long parameter lotId and request body CarDetails.
      CarDetails is a simple class with field car number,car width,car height and its getteres and setters.
      i am assume that when a car reaches the parking lot its car number also-
          automatically detected along with dimensions and provided to the system.      
      if api call succes it returns lot details 
 
 7)Lot release-:
 
      the api is /api/lotDetails/lotRelease
      The request body for api is carDetails.
      i assume that when the car moves out carNumber,car dimensions are detected by system.
      when the api calls the lotStatus changes to available from booking and return lotdetais.
