import React, { Component } from 'react';
import ItemService from '../services/ItemService';

class AddItemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            itemName: '',
            discounted: false,
            discountPercentage: '',
            itemPrice: '',
            discountedPrice: ''
        }
        this.changeItemName = this.changeItemName.bind(this);
        this.changeDiscounted = this.changeDiscounted.bind(this);
        this.changeDiscountPercentage = this.changeDiscountPercentage.bind(this);
        this.changeItemPrice = this.changeItemPrice.bind(this);
        this.changeDiscountedPrice = this.changeDiscountedPrice.bind(this);
        this.saveItem = this.saveItem.bind(this);
    }

    saveItem = (e) => {
        e.preventDefault();
        let item = { 
            itemName: this.state.itemName, 
            discounted: this.state.discounted, 
            discountPercentage: this.state.discountPercentage, 
            itemPrice: this.state.itemPrice,
            discountedPrice: this.state.discountedPrice
         };
        console.log('item => ' + JSON.stringify(item));

        ItemService.addItems(item).then(res => {
            this.props.history.push('/items');
        });
    }

    changeItemName = (event) => {
        this.setState({ itemName: event.target.value });
    }

    changeDiscounted = (event) => {
        const checked = event.target.checked;
        if(checked=== true){
            this.setState({discounted: true});
        } else {
            this.setState({discounted: false});
        }
        // this.setState({ isDiscounted: event.target.value });
    }

    changeDiscountPercentage = (event) => {
        this.setState({ discountPercentage: event.target.value });
    }

    changeItemPrice = (event) => {
        this.setState({ itemPrice: event.target.value });
    }
 
    changeDiscountedPrice = (event) => {
        this.setState({ discountedPrice: event.target.value});
    }

    cancel(e) {
        e.preventDefault();
        this.props.history.push('/items');
    }

    render() {
        return (
            <div>
                <br />
                <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <br />
                            <h3 className='text-center'>Add Item</h3>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group'>
                                        <label>Item Name : </label>
                                        <input placeholder='Item Name' name='itemName' autoComplete='off' className='form-control' value={this.state.itemName} onChange={this.changeItemName} />
                                    </div><br />
                                    <div className='form-group'>
                                        <label>Regular Price : </label>
                                        <input type="number" placeholder='Regular Price' autoComplete='off' name='itemPrice' className='form-control' value={this.state.itemPrice} onChange={this.changeItemPrice} />
                                    </div><br />
                                    <div className='form-group'>
                                        <input className='form-check-input' type="checkbox" name='discounted' autoComplete='off' value="true" onChange={this.changeDiscounted} id="flexCheckDefault"/>                                       
                                        &nbsp;&nbsp;<label>Discounted </label><br />
                                    </div><br />
                                    <div className='form-group'>
                                        <label>Discount Percentage : </label>
                                        <input type="number" placeholder='Discount Percentage' autoComplete='off' name='discountPercentage' className='form-control' value={this.state.discountPercentage} onChange={this.changeDiscountPercentage} />
                                    </div><br />
                                    <div className='form-group'>
                                        <label>Discounted Price : </label>
                                        <input type="number" placeholder='Dicounted Price'  autoComplete='off'name='discountedPrice' className='form-control' value={this.state.discountedPrice} onChange={this.changeDiscountedPrice} />
                                    </div>
                                    <br />
                                    <button className='btn-add' onClick={this.saveItem}>Save</button>
                                    <button className='btn-add' onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default AddItemComponent;