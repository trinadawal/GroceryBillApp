import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import ItemService from '../services/ItemService';
import BillService from '../services/BillService';

class ItemListComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            items: [],
            totalRegularBill: '',
            totalDiscountedBill: ''

        }

        this.addItem = this.addItem.bind(this);
        this.updateItem = this.updateItem.bind(this);
        this.deleteItem = this.deleteItem.bind(this);
        this.generateBill = this.generateBill.bind(this);
    }


    componentDidMount() {
        ItemService.getItems().then((res) => {
            this.setState({ items: res.data });
        });
        BillService.getTotalRegularBill().then((res) => {
            this.setState({ totalRegularBill: res.data});
        });
        BillService.getTotalDiscountedBill().then((res) => {
            this.setState({ totalDiscountedBill: res.data});
        });
    }

    addItem() {
        this.props.history.push('/add-item');
    }

    updateItem(itemName) {
        this.props.history.push(`/update-item/${itemName}`);
    }

    deleteItem(itemName) {
        ItemService.deleteItem(itemName).then(res => {
            this.setState({ item: this.state.items.filter(item => item.itemName !== itemName) });
            window.location.reload(false);
        });
    }

    generateBill() {
        this.props.history.push('/bill');
    }

    refreshPage() {
        window.location.reload(false);
    }

    render() {
        return (
            <div className='container '>
                <br />
                <h4 className='text-center bold-text'>Items List</h4><br />

                <div className='row'>
                    <table className='text-center bord   table table-hover   '>

                        <thead className='background-color thead-text'>
                            <tr>
                                <th>Name</th>
                                <th>Discounted</th>
                                <th>% Discount</th>
                                <th>Regular Price</th>
                                <th>Discounted Price</th>
                                <th>Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.items.map(
                                    item =>
                                        <tr key={item.itemName}>
                                            <td>{item.itemName}</td>
                                            <td>{JSON.stringify(item.isDiscounted)}</td>
                                            <td>{item.discountPercentage}%</td>
                                            <td>${item.itemPrice}</td>
                                            <td>${item.discountedPrice}</td>
                                            <td>
                                                <button onClick={() => this.updateItem(item.itemName)} className="btn-action">Update</button>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <button onClick={() => this.deleteItem(item.itemName)} className="btn-action">Delete</button>
                                            </td>

                                        </tr>
                                )
                            }
                            {/* <tr>
                                <td><b>Total</b></td>
                                <td></td>
                                <td></td>
                                <td>${this.state.totalRegularBill}</td>
                                <td>${this.state.totalDiscountedBill}</td>
                                <td></td>
                            </tr> */}

                        </tbody>
                    </table>
                </div><br />
                <div>
                    <button className='btn-add' onClick={this.addItem}>+ Add New Item</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <button className='btn-add' onClick={this.generateBill}>Generate Bill</button>
                </div>
            </div>
        );
    }
}

export default ItemListComponent;