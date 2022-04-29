import './App.css';
import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import HeaderComponent from './components/HeaderComponent';
import ListUsers from './components/Users/ListUsersComponent';
import FooterComponent from './components/FooterComponent';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import {Container, Nav, Navbar} from "react-bootstrap";
import "bootswatch/dist/minty/bootstrap.min.css"
import ListEvents from './components/Events/ListEventsComponent';
import ListMarkets from './components/Market/ListMarketsComponent';
import CreateUser from './components/Users/CreateUserComponent';

// root component to render inside reactDOM
function App() {
  return (
    <BrowserRouter>
    <React.Fragment>
      <Navbar variant="dark" bg="primary">
        <Container>
          <Navbar.Brand as={Link} to={'/'}> Lets Book It! </Navbar.Brand>

            <Nav className="me-auto">   

              <Nav.Link as={Link} to={'/users'} className="nav-link"> Users </Nav.Link>
              <Nav.Link as={Link} to={'/markets'} className="nav-link"> Markets </Nav.Link>
              <Nav.Link as={Link} to={'/events'} className="nav-link"> Events </Nav.Link>

            </Nav>

        </Container>
        
      </Navbar>

      <Container>
      <div id="demo" class="carousel slide" data-ride="carousel">

<ul class="carousel-indicators">
  <li data-target="#demo" data-slide-to="0" class="active"></li>
  <li data-target="#demo" data-slide-to="1"></li>
  <li data-target="#demo" data-slide-to="2"></li>
</ul>


<div class="carousel-inner">
  <div class="carousel-item active">
   <h3>1</h3>
  </div>
  <div class="carousel-item">
  <h3>Hello2</h3>
  </div>
  <div class="carousel-item">
  <h3>Hello3</h3>
  </div>
</div>


<a class="carousel-control-prev" href="#demo" data-slide="prev">
  <span class="carousel-control-prev-icon"></span>
</a>
<a class="carousel-control-next" href="#demo" data-slide="next">
  <span class="carousel-control-next-icon"></span>
</a>

</div>
     
      </Container>
      <Container>
      <br></br>
      <Routes>
        <Route exact path='/'> </Route>
        <Route exact path='/users' element={<ListUsers />}></Route>
        <Route exact path='/users/create' element={<CreateUser />}></Route>
        <Route exact path='/markets' element={<ListMarkets />}></Route>
        <Route exact path='/events' element={<ListEvents />}></Route>
      </Routes>
      </Container>
    </React.Fragment>
    </BrowserRouter>
  
  );
}

export default App;