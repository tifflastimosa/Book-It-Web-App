import React, { Component } from 'react'
import UsersService from '../../services/UsersService'

class CreateUser extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // id: this.props.match.params.id,
            username: '',
            password: '',
            firstName: '',
            lastName: '',
            email: '', 
            dateOfBirth: '',
            role: ''
        }
        this.changeUsername = this.changeUsername.bind(this);
        this.changePassword = this.changePassword.bind(this);
        this.changeFirstName = this.changeFirstName.bind(this);
        this.changeLastName = this.changeLastName .bind(this);
        this.changeEmail = this.changeEmail.bind(this);
        this.changeDateOfBirth = this.changeDateOfBirth.bind(this); 
        this.changeRole = this.changeRole.bind(this);
        this.saveUser = this.saveUser.bind(this);
        // this.cancel = this.cancel.bind(this);

    }

    componentDidMount() {
        if(this.state.id === '_add') {
            return
        } else {
            UsersService.getUserById(this.state.id).then( (res) => {
                let user = res.data;
                this.setState({
                    username: user.username,
                    password: user.password,
                    firstName: user.firstName,
                    lastName: user.lastName,
                    email: user.email,
                    dateOfBirth: user.dateOfBirth,
                    role: user.role
                })
            })
        }
     }

     saveUser = (u) => {
         u.preventDefault();
         // employee javascript object 
         let user = {
                        username: this.state.username, 
                        password: this.state.password,
                        firstName: this.state.firstName,
                        lastName: this.state.lastName,
                        email: this.state.email,
                        dateOfBirth: this.state.dateOfBirth,
                        role: this.state.role
        };
        console.log('user => ' + JSON.stringify(user));

        if(this.state.id === '_add'){
            UsersService.createUser(user).then(res =>{
                this.props.history.push('/users');
            });
        }else{
            UsersService.updateUser(user, this.state.id).then( res => {
                this.props.history.push('/users');
            });
        }
     }

    changeUsername= (event) => {
        this.setState({username: event.target.value});
    }

    changePassword= (event) => {
        this.setState({password: event.target.value});
    }

    changeFirstName= (event) => {
        this.setState({firstName: event.target.value});
    }

    changeLastName= (event) => {
        this.setState({lastName: event.target.value});
    }

    changeEmail= (event) => {
        this.setState({email: event.target.value});
    }

    changeDateOfBirth= (event) => {
        this.setState({dateOfBirth: event.target.value});
    }

    changeRole= (event) => {
        this.setState({role: event.target.value});
    }

    cancel() {
        this.props.history.push('/users')
    }

    render() {
        return (
            <div>
                <h1> New User Account Information</h1>
                <div className = "container">
                    <div>
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center"> Account Information</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> Username</label>
                                        <input placeholder = "Username" name="username" className="form-control"
                                            value={this.state.username} onChange={this.changeUsername}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Password</label>
                                        <input placeholder = "Password" name="password" className="form-control"
                                            value={this.state.password} onChange={this.changePassword}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> First Name</label>
                                        <input placeholder = "First Name" name="firstName" className="form-control"
                                            value={this.state.firstName} onChange={this.changeFirstName}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Last Name</label>
                                        <input placeholder = "Last Name" name="lastName" className="form-control"
                                            value={this.state.lastName} onChange={this.changeLastName}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Email</label>
                                        <input placeholder = "Email" name="password" className="form-control"
                                            value={this.state.email} onChange={this.changeEmail}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Date of Birth</label>
                                        <input placeholder = "Date of Birth" name="dateOfBirth" className="form-control"
                                            value={this.state.dateOfBirth} onChange={this.changeDateOfBirth}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Role</label>
                                        <input placeholder = "Role" name="password" className="form-control"
                                            value={this.state.role} onChange={this.changeRole}/>
                                    </div>
                                    <br></br>
                                    <button class="btn btn-success" onClick={this.saveUser}> Save</button>
                                    <button class="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}> Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}

export default CreateUser;