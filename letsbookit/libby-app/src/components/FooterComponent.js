import React, { Component } from "react";

class FooterComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

        }
    }

    render() {
        return (
            <div>
                <footer className = "footer">
                    <span className="text-muted">cs 5200 Introduction to DBMS Project 2022</span>
                </footer>
            </div>
        )
    }

}

export default FooterComponent