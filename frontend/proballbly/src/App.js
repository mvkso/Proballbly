import { render } from '@testing-library/react';
import React, {Component} from 'react';
import Team from "./Team"
import Header from "./components/Header"
import Nav from "./components/Navigation"
import "./App.css"

class App extends Component{

  state = 
  {
    data: [],
  }

  componentDidMount(){
    fetch('http://localhost:8080/api/bpl/all')
    .then(response => response.json())
    .then(data => {
      console.log(data);
      this.setState({data})
    }
    );
  }

  render(){
    return (
      <div class="base-container">
        <Header/>
        {/* </div>{this.state.data.map(team => <Team info={team}/> )} */}
        <Nav />
      </div>
    );
  }


}
export default App;