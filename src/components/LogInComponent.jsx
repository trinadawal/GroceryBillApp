import React, { Component } from 'react';
import ClerkService from '../services/ClerkService';

class LogInComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            clerkName: '',
            clerkPassword: ''
        }

        this.clerkNameChange = this.clerkNameChange.bind(this);
        this.clerkPasswordChange = this.clerkPasswordChange.bind(this);
        this.loginClerk = this.loginClerk.bind(this);
    }

    clerkNameChange = (event) => {
        this.setState({clerkName : event.target.value});
    }

    clerkPasswordChange = (event) => {
        this.setState({clerkPassword: event.target.value})
    }

    loginClerk = (event) => {
        // event.preventDefault();

        // ClerkService.clerkLogIn(this.state.clerkName, this.state.clerkPassword).then((res) => {
        //     if(res.data.isValidated) {
        //     this.props.history.push('/items');
        //     } else {
        //         alert("Username or Password is incorrect. Try again.");
        //     }
        // })
        this.props.history.push('/items');
    }
    
    render() {
        return (
            <div className='container'><br /><br/><br/><br/>
                <div className='row'>
                    <div className='card col-md-6 offset-md-3 offset-md-3'> <br/>
                    <h3 className='text-center'>Log In</h3>
                    <div className='card-body'>
                        <form onSubmit={this.loginClerk}>
                            <div className='form-group'>
                                <label>Clerk Name : </label>
                                <input className='form-control'autoComplete='off' name='clerkName' type="text" value={this.state.clerkName} placeholder="Name" onChange={this.clerkNameChange} />
                            </div><br/>
                            <div className='form-group'>
                                <label>Password : </label>
                                <input className='form-control' autoComplete='off' name='clerkPassword' type="password" value={this.state.clerkPassword} placeholder="Password" onChange={this.clerkPasswordChange} />
                            </div><br/>
                            <button className='btn-add' type='submit' onClick={this.loginClerk}>Log In</button>
                        </form>
                    </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default LogInComponent;