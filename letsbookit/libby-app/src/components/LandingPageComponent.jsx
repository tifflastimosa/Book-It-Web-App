import React, { Component } from "react";
import { Link } from "react-router-dom";
import pax from "../media/pax.jpg";
import ballard from "../media/ballardfm.jpg"
import nightmarket from "../media/nightmarket.jpg"
import { Carousel } from "bootstrap";
import { Container } from "react-bootstrap";

class LandingPage extends Component {

    render() {
        return(
            <div id="demo" class="carousel slide" data-bs-ride="carousel">
                <center><h1>Book a stand at a gathering near you!</h1></center>
                <Container>
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
                </div>
                <div class="carousel-inner">
                     <div class="carousel-item active">
                        <img  src={pax} alt="fireSpot" width="1500" height="800"/>
                    </div>
                    <div class="carousel-item">
                        <img  src={ballard} alt="fireSpot" width="1500" height="800"/>
                    </div>
                    <div class="carousel-item">
                        <img  src={nightmarket} alt="fireSpot" width="1500" height="800"/>
                    </div>
                </div>
                
                <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </button>
                </Container>
             
            </div>
        )
    }
}

export default LandingPage;