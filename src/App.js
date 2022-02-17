import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ItemListComponent from './components/ItemListComponent';
import HeaderComponent from './components/HeaderComponent';
import AddItemComponent from './components/AddItemComponent';
import UpdateItemComponent from './components/UpdateItemComponent';
import LogInComponent from './components/LogInComponent';
import GenerateBillComponent from './components/GenerateBillComponent';

function App() {
  return (
  
      <Router>
        
        <div >
          <HeaderComponent />
          <div>
            <Switch> 
              <Route path="/" exact component={LogInComponent}></Route>
              <Route path="/items" component={ItemListComponent}></Route>
              <Route path="/add-item" component={AddItemComponent}></Route>
              <Route path="/update-item/:itemName" component={UpdateItemComponent}></Route>
              <Route path="/bill" component={GenerateBillComponent}></Route>
              {/* <Route path="/log-in" component={LogInComponent}></Route> */}
            </Switch>
          </div>
        </div>
      </Router>

  );
}

export default App;
