import React, { Component } from 'react';
import ItemService from '../services/ItemService';

class UpdateItemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            itemName: this.props.match.params.itemName,
            isDiscounted: '',
            discountPercentage: '',
            itemPrice: '',
            discountedPrice: ''
        }
        this.changeItemName = this.changeItemName.bind(this);
        this.changeIsDiscounted = this.changeIsDiscounted.bind(this);
        this.changeDiscountPercentage = this.changeDiscountPercentage.bind(this);
        this.changeItemPrice = this.changeItemPrice.bind(this);
        this.changeDiscountedPrice = this.changeDiscountedPrice.bind(this);
        this.updateItem = this.updateItem.bind(this);
    }

    componentDidMount() {
        ItemService.getItemsByName(this.state.itemName).then((res) => {
            let item = res.data;
            this.setState({
                itemName: item.itemName,
                isDiscounted: item.isDiscounted,
                discountPercentage: item.discountPercentage,
                itemPrice: item.itemPrice,
                discountedPrice: item.discountedPrice
            });
        });
    }

    updateItem = (e) => {
        e.preventDefault();
        let item = {
            itemName: this.state.itemName,
            isDiscounted: this.state.isDiscounted,
            discountPercentage: this.state.discountPercentage,
            itemPrice: this.state.itemPrice,
            discountedPrice: this.state.discountedPrice
        };
        console.log('item => ' + JSON.stringify(item));

        ItemService.updateItem(item, this.state.itemName).then(res => {
            this.props.history.push('/items');
        });
    }

    changeItemName = (event) => {
        this.setState({ itemName: event.target.value });
    }

    changeIsDiscounted = (event) => {
        const checked = event.target.checked;
        if (checked === true) {
            this.setState({ isDiscounted: true });
        } else {
            this.setState({ isDiscounted: false });
        }
        // this.setState({ discounted: event.target.value });
    }

    changeDiscountPercentage = (event) => {
        this.setState({ discountPercentage: event.target.value });
    }

    changeItemPrice = (event) => {
        this.setState({ itemPrice: event.target.value });
    }

    changeDiscountedPrice =(event) => {
        this.setState({ discountedPrice: event.target.value});
    }

    cancel() {
        this.props.history.push('/items');
    }

    render() {
        return (
            <div >
                <br />
                <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <br />
                            <h3 className='text-center'>Update Item</h3>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group'>
                                        <label>Item Name : </label>
                                        <input placeholder='Item Name' name='itemName' autoComplete='off' readOnly className='form-control' value={this.state.itemName} />
                                    </div><br />
                                    <div className='form-group'>
                                        <label>Regular Price : </label>
                                        <input type="number" placeholder='Regular Price' autoComplete='off' name='itemPrice' className='form-control' value={this.state.itemPrice} onChange={this.changeItemPrice} />
                                    </div><br />
                                    <div className='form-group'>
                                        <input className='form-check-input' type="checkbox" autoComplete='off' name='isDiscounted' value="true" onChange={this.changeIsDiscounted} checked={this.state.isDiscounted} id="flexCheckDefault" />
                                        &nbsp;&nbsp;<label htmlFor='flexCheckDefault'>Discounted </label>
                                    </div><br />
                                    <div className='form-group'>
                                        <label>Discount Percentage : </label>
                                        <input type="number" placeholder='Discount Percentage' autoComplete='off' name='discountPercentage' className='form-control' value={this.state.discountPercentage} onChange={this.changeDiscountPercentage} />
                                    </div><br />
                                    
                                    <div className='form-group'>
                                        <label>Discounted Price : </label>
                                        <input type="number" placeholder='Discounted Price' autoComplete='off' name='discountedPrice' className='form-control' value={this.state.discountedPrice} onChange={this.changeDiscountedPrice} />
                                    </div><br />
                                    <button className='btn-add' onClick={this.updateItem}>Save</button>
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

export default UpdateItemComponent;