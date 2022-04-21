import React, { Component } from "react";
import MarketsService from "../../services/MarketsService";

class ListMarkets extends Component {
    constructor(props) {
        super(props)
        this.state = {
            markets: []
        }

        this.deleteMarketById = this.deleteMarketById.bind(this);

    
    }

    componentDidMount() {
        MarketsService.getMarkets().then((res) => {
            this.setState({ markets: res.data});
        })
    }

    deleteMarketById(id) {
        MarketsService.deleteMarketById(id).then ( res => {
            this.setState({ markets: this.state.markets.filter(market => market.id !== id)})
        })
       
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Markets List</h2>
                <div className = "row">
                <button className="btn btn-primary" onClick={this.addEmployee}> Add Market  Placeholder </button>
                    <table className = "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> Market Id</th>
                                <th> Name</th>
                                <th> Description</th>
                                <th> Frequency</th>
                                <th> Contact Number</th>
                                <th> Contact Email</th>
                                <th> Website</th>
                                <th> Social Media</th>
                                <th> Update Market</th>
                                <th> Delete Market </th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.markets.map(
                                    market =>
                                    <tr key = {market.id}>
                                        <td> {market.id} </td>
                                        <td> {market.name} </td>
                                        <td> {market.description} </td>
                                        <td> {market.frequency} </td>
                                        <td> {market.contactNumber} </td>
                                        <td> {market.contactEmail} </td>
                                        <td> {market.website} </td>
                                        <td> {market.socialMedia} </td>
                                        <td><button style={{marginLeft: "10px"}} className="btn btn-info"> Update </button></td>
                                        <td><button style={{marginLeft: "10px"}} onClick={ () => this.deleteMarketById(market.id)} className="btn btn-secondary">Delete </button></td>
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

export default ListMarkets;
