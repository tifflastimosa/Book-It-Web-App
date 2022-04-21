import React, { Component } from "react";
import EventsService from "../../services/EventsService";

class ListEvents extends Component {
    constructor(props) {
        super(props)
        this.state = {
            events: []
        }

        this.deleteEventById = this.deleteEventById.bind(this);
    }

    componentDidMount() {
        EventsService.getEvents().then((res) => {
            this.setState({events: res.data})
        })
    }

    deleteEventById(id) {
        EventsService.deleteEvent(id).then (res => {
            this.setState({ events: this.state.events.filter(event => event.id !== id)})
        })
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Events List</h2>
                <div classNamee = "row">
                <button className="btn btn-primary" onClick={this.addEvent}> Add Event Placeholder </button>
                    <table className = "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> Event Id</th>
                                <th> Event Name</th>
                                <th> Event Start Date</th>
                                <th> Event End Date</th>
                                <th> Location</th>
                                <th> Venue Layout</th>
                                <th> Update Event</th>
                                <th> Delete Event</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.events.map(
                                    event =>
                                    <tr key = {event.id}>
                                        <td> {event.id} </td>
                                        <td> {event.name} </td>
                                        <td> {event.start} </td>
                                        <td> {event.end} </td>
                                        <td> {event.location} </td>
                                        <td> {event.venueLayout} </td>
                                        <td><button style={{marginLeft: "10px"}} className="btn btn-info"> Update </button></td>
                                        <td><button style={{marginLeft: "10px"}} onClick={ () => this.deleteEventById(event.id)} className="btn btn-secondary">Delete </button></td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }


}

export default ListEvents;