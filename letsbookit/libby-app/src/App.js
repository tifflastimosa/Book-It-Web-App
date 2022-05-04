import './App.css';
import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import ListUsers from './components/Users/ListUsersComponent';
import FooterComponent from './components/FooterComponent';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import {Container, Nav, Navbar} from "react-bootstrap";
import "bootswatch/dist/minty/bootstrap.min.css"
import ListEvents from './components/Events/ListEventsComponent';
import ListMarkets from './components/Market/ListMarketsComponent';
import CreateUser from './components/Users/CreateUserComponent';
import LandingPage from './components/LandingPageComponent';
import UpdateUser from './components/Users/UpdateUserComponent';
// root component to render inside reactDOM
function App() {
  return (
    <BrowserRouter>
    <React.Fragment>
      {/* create the navbar */}
      <Navbar variant="dark" bg="primary">
        <Container>
          <Navbar.Brand as={Link} to={'/'}> Let's Book It! </Navbar.Brand>

            <Nav className="me-auto">   

              <Nav.Link as={Link} to={'/users'} className="nav-link"> Users </Nav.Link>
              <Nav.Link as={Link} to={'/markets'} className="nav-link"> Markets </Nav.Link>
              <Nav.Link as={Link} to={'/events'} className="nav-link"> Events </Nav.Link>

            </Nav>
        </Container>
      </Navbar>

      {/* container for links in the navbar */}
      <Container>
      <br></br>
      <Routes>
        <Route exact path='/' element={<LandingPage />}></Route>
        <Route exact path='/users' element={<ListUsers />}></Route>
        <Route exact path='/users/create' element={<CreateUser />}></Route>
        <Route exact path='/users/update' element={<UpdateUser />}></Route>
        <Route exact path='/markets' element={<ListMarkets />}></Route>
        <Route exact path='/events' element={<ListEvents />}></Route>
      </Routes>
      </Container>
      
      <center><FooterComponent></FooterComponent></center>
    </React.Fragment>
    </BrowserRouter>
  
  );
}


export default App;