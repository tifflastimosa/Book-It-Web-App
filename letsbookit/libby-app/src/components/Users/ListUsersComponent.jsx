import React, { Component } from "react";
import UsersService from "../../services/UsersService";
import { Link } from "react-router-dom";

// building the component to call into App so that it will display
class ListUsers extends Component {
    constructor(props) {
        super(props)
        this.state =  {
            users: []
        }
        // bind event in constructor
        this.deleteUserById = this.deleteUserById.bind(this);
        this.addUser = this.addUser.bind(this);


    }

    // call rest api all - use component mount
    componentDidMount() {
        UsersService.getUsers().then((res) => {
            // store users data in users array in this.state
            this.setState({ users: res.data });
        })
    }

    addUser() {
        this.props.history.push('/add-user');
    }

    viewUser(id) {
        this.props.history.push(`/view-employee/${id}`);
    }

    deleteUserById(id) {
        UsersService.deleteUser(id).then( res => {
            this.setState({ users: this.state.users.filter(user => user.id !== id)});
        })
    }




    render() {
        return (
            <div>
                <h2 className="text-center">Users List</h2>
                <div className = "row">
                    <Link to="/add-user">
                    <button className="btn btn-primary" onClick={this.addUser}> Add User</button>
                    </Link>


                    <table className = "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> User Id</th>
                                <th> User First Name</th>
                                <th> User Last Name Name</th>
                                <th> Update Account </th>
                                <th> Delete User</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user => 
                                    <tr key = {user.id}>
                                        <td> {user.id} </td>
                                        <td> {user.firstName} </td>
                                        <td> {user.lastName} </td>
                                        <td><button style={{marginLeft: "10px"}} className="btn btn-info"> Update </button></td>
                                        <td><button style={{marginLeft: "10px"}} onClick={ () => this.deleteUserById(user.id)} className="btn btn-secondary">Delete </button></td>
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

export default ListUsers;