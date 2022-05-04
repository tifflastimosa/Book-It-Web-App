
# Lets Book It Web Application
## Problem Statement: Describe the problem that your project is trying to solve.
To date, there exists no single entity that serves as a one-stop shop for finding, advertising, reserving, and/or managing stands at popular events like fairs, farmers markets, and conventions. Vendors want the flexibility of managing multiple stands (across varying events and frequencies) in one location. Similarly, bargain hunters and event attendees want the ability and convenience of viewing when and where their favorite vendors and events will be. Existing practices for advertising events such as printing out and posting flyers, websites, word-of-mouth, etc. fall short when time sensitive updates are needed. Our project provides  a single, reliable source for locating the information event vendors and attendees need at the time of need.

## Solution Statement: Describe the solution you implemented to solve the problem.
**LetsBookIt** is a web-based application that provides an organizer, represented as a MarketStaff, of a gathering (i.e. an event organizer or farmers market staff) to advertise and manage event bookings. Vendors (i.e. game studio, farmer, or artist) can view a list of events in a given town and reserve stands at an event of their choosing. Event organizers can advertise and track the stand bookings, as well as set the price of the stand for Vendors to reserve it. Many of the methods to our problem statement are implemented in the Events and Stands classes.

Moreover, we exposed our database to the client side by creating CRUD endpoints for all classes, which include: User, Market Staff, Vendor Staff, Event, Stand, and Vendor. For example, a vendor would be able to search for events in a given location or a market staff, an end user, would be able to create multiple stands that are available for booking.

For additional information regarding our api, please see [P3: User Interface Enhancements Milestone](#P3) and our [api documentation](https://documenter.getpostman.com/view/16498854/UyrHeshz).

In addition to exposing our database, we also began implementing the front end with React to give an end user the ability to interact with our database. We used the Axios library because it allows the front end to make promise-based HTTP requests. This allows the front end to communicate with the backend.

## User Description: Describe the typical user(s) that would use your solution.
The typical users of LetsBookIt fall into the category of either the staff of a market or the staff of a vendor. The **market staff member** can be a manager of the market, an organizer of the events the market holds or an associate that assists with the day-to-day operations of the market and its events. These market staff users have the ability to use this application to keep the information on their market up to date for other users to look up. They are also able to create events and the associated stands at the event and then keep track of what stands have been booked and by what vendors.

The **vendor staff member** can also be either a manager for the vendor, an organizer, or a general associate that works for the vendor. In addition to keeping the information on their vendor up to date for others to look up, these vendor staff users can look for events that markets are putting on, get important information on these events and details about the stands that are available to book at them and then book them.

## Domain Objects Description: Describe at least two of the domain objects you implemented in your solution.
The domain objects implemented within LetsBookIt are market, event, stand, and vendor.

The **market domain object** represents an organization that puts on events that have stands that can be booked by vendors. A market is organized and ran by market staff users and can organize many events. The information stored about a market in addition to its name and description is what frequency that it holds events, as well as contact information such as phone number, email, website, and social media link.

The **event domain object** represents an event that is put on by a market at a specific time in a specific location that consists of stands that are available for vendors to book. An event belongs to a single market and consists of many stands. An event also can’t exist without having a market that is organizing it. In addition to storing the name, starting, and ending date and time, and the location of the event, it also stores a link to a layout of the stands that are at the event that can be referred to when looking at the location of stands verses each other.

The **stand domain object** represents a single stand that can be booked by a vendor and is located at an event organized by a market. When initially created, a stand is marked as not booked and does not have an associated vendor and is available to be booked by a single vendor. A stand is unable to exist without an associated event that it is a part of. The information stored about a stand in addition to its name, booked status, and associated vendor is notes on the features of the stand as well as the price to book it and the last time anything was updated for any of this information.

The **vendor domain object** represents an organization or company that books stand or stands for their use at events that are put on by markets. A vendor is organized and run by vendor staff users and can book stands at different events that are held by different markets. The information stored about a market in addition to its name and description is its contact information such as phone number, email, website, and social media link.

<h2 id="P3">P3: User Interface Enhancements Milestone</h2>
To accomplish this milestone, we implemented User Interface Enhancements in the Events class. We implemented in the User Interface Enhancement in only 1 class per the milestone requirement. Thus, the Event class is a class that is on a many side of one relationship and on a 1 side of another relationship.

**1. User Interface Enhancement 1: If the record being edited is on the many side of a 1 to many relationship, then add a link to the record on the 1 side's edit screen.**

*Relationship: Market (1 side) to Events (Many side)*
- We achieved this by implementing the method getMarket in the EventController and EventService. The getMarket method in EventController will make the request to EventService, which will communicate with the EventRepository to get the Market associated with the provided event id. In the Events edit screen we added the endpoint http://localhost:8080/events/market/event_id, which retrieves the Market from the database with the given event id.

**2. Use Interface Enhancement 2: If the record being edited is on the one side of a 1 to many relationship, then add a single link that navigates to a list screen that displays the associated records on the many side.**

*Relationship: Event (1 side) to Stands (Many side)*
- We achieved this by implementing a getStands method in the EventController and EventService. The getStands method in EventController will make the request to EventService, which will then communicate with the EventRepository to get the list of stands associated with the provided event id. In the Events edit screen we added the endpoint http://localhost:8080/events/stands/event_id, which retrieves the list of Stands from the database with the given event id.

**3. User Interface Enhancement 3: additional**
- In this User Interface enhancement, we implemented a findEventByLocation method in EventController and getEventByLocation in EventService. The findEventByLocation will make the request to EventService when provided by the desired search location, which will communicate with the EventRepository to get all the events given a location such as Seattle, WA. In the Events edit screen, we added the endpoint http://localhost:8080/events/find/location, which retrieves the list of Events from the database with the given location.

**4. User Interface Enhancement 4: additional**
 - In this User Interface enhancement, we implemented a createStands method in the EventController and EventService. The createStands method will allow an end user to create multiple stands associated with an event when given the event id, the number of stands the end user wants to make public to vendors to reserve, and the default price to reserve the stand. In the Events edit screen, we added the endpoint http://localhost:8080/events/event_id/create-stands/num/price.

## Getting Started
- This project was built in IntelliJ using Spring Boot. Note that we are using SDK Java 17.

- Download or clone our repository to your local machine. Change directory to
letsbookit.

```
cd letsbookit
```

- When getting started, the back end and part of the front end will be running on port 8080, while the other part of the front end is running on port 3000.
- Please note that you may have to utilize the back button in your browser to get back to the webpage landing on part 3000.

### Building the Java Program
1. Please go to pom.xml file in letsbookit project file.
2. Load the dependencies.
3. Once dependences are loaded, you are able to build and run the application.

### Running the Front End
- React was used to build the front end.
- To launch the front end of the project, you will need to install Node.js
and NPM. This will allow you to use the npm commands in the terminal.
- If you are running this program on a Mac, please reference this
[article](https://medium.com/@hayasnc/how-to-install-nodejs-and-npm-on-mac-using-homebrew-b33780287d8f) for instructions.
- If you are running this program on a Windows, please reference this [article](https://www.freecodecamp.org/news/how-to-install-node-js-and-npm-on-windows/) for instructions.

- To setup the front end, in your terminal, change your directory to libby-app.

Once in said package, type the below in:

```
cd libby-app
npm install
```

`npm install`will install and load the dependencies to run the front end. From there, once you have the Lets Book It running, in your terminal, input `npm start`

## Cloud Database
- AWS RDS was utilized to avoid any issue when running the web application on you local machine in making CRUD requests via Postman or the User Interface. If you would like to view the database as you test our api via Postman, below is the instruction to setup the database in IntelliJ. Do let us know if you run into any technical issues.

### Instructions
1. After opening the project in IntelliJ, there should be a Database panel on right sidebar. If not, click on Database on the right sidebar and the Database panel should appear. Please see [Manage Data Sources](https://www.jetbrains.com/help/idea/managing-data-sources.html#configure-display-options-for-data-sources) for additional information.
2. Once in the panel, go to Data Source Properties (Mac Shortcut ⌘I). A Data Source Properties window should pop up. Complete the following:

```
Name: letsbookit-sql
Host: letsbookit-sql.cp7ciikcbk1m.us-west-2.rds.amazonaws.com
User: admin
Password: northeastern
Database: db_design_final_project_database
URL: jdbc:mysql://letsbookit-sql.cp7ciikcbk1m.us-west-2.rds.amazonaws.com/db_design_final_project_database
```

3. Prior to applying properties, please test the connection beforehand. *If you run into any issues in connecting, please reach out to us.*

* Once the course has ended, we intend to change the password for admin out of an abundance of caution.

## Future of the Project

### Current Known Bugs/issues
 - Currently experiencing bugs with React as we are all unfamiliar with front end development.
 - Add additional validations to catch for invalid input by the end users.
 - Implement security for user login and credentials.

### Future of the Project
- Growing to include an Attendee user.
- Creating additional endpoints that will allow for users to interact more with the database. For example, an endpoint in vendor that will connect with the stand record or object to reserve a stand by changing the booked field from false to true.
- Fully implement a front end for end users to take advantage of our booking system.
- Deploy our Let's Book It web application to an Amazon EC2 instance.
