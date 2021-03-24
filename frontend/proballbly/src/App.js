import { render } from '@testing-library/react';
import React, {Component} from 'react';
import Team from "./Team"
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
      <div>
        {this.state.data.map(team => <Team info={team}/> )}
      </div>
    );
  }


}
export default App;