import React, { Component } from 'react';

class HeaderComponent extends Component {
    constructor(props) {
        super(props)
        
        this.state = {
            
        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className='navbar background-color'>
                    <div className='nav-text'>&nbsp;&nbsp;&nbsp;&nbsp;Grocery Bill Application</div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;