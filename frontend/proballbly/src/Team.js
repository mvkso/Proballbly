import { render } from '@testing-library/react';
import React, {Component} from 'react';
class Team extends Component{

  render(){
    return (
      <div>
          <p>------------------</p>
          <p>{this.props.info.id}</p>
          <p>{this.props.info.name}</p>
      </div>
    );
  }


}
export default Team;