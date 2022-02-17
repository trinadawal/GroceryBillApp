import React, { Component } from 'react';
import BillService from '../services/BillService';

class GenerateBillComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            totalRegularBill: '',
            totalDiscountedBill: ''
        }

    }

    componentDidMount() {
        BillService.getTotalRegularBill().then((res) => {
            this.setState({ totalRegularBill: res.data})
        });
    }

    render() {
        return (
            <div>
                <div className='container'><br />
                    <div className='card col-md-6 offset-md-3 offset-md-3'><br />
                        <div className=''>
                            <div className='text-center'><b>Official Receipt</b></div><br />
                            {/* <div><b>&nbsp;-------------------------------------------------------------------------------------</b></div> */}
                            <table className='text-center  table'>
                                <thead>
                                    <tr>
                                        <th>Items</th>
                                        <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>{this.state.totalRegularBill}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default GenerateBillComponent;