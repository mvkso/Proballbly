import React, {Component} from 'react';
import "./Standings.css"
class LaLigaStandings extends Component{

    state = 
  {
    data: [],
  }

  componentDidMount(){
    fetch('http://localhost:8080/competitions/2014/standings')
    .then(response => response.json())
    .then(data => {
      console.log(data);
      this.setState({data})
    }
    );
    }

    render(){
    return(
            <div className="ptable">
              <h1 className="headin">La Liga Standings</h1>
              
                {this.state.data.map((standing) =>{
                  return standing.type === "TOTAL"?
                  <table>
                  <tr className="col">
                      <th>#</th>
                      <th>Team</th>
                      <th>GP</th>
                      <th>W</th>
                      <th>D</th>
                      <th>L</th>
                      <th>GD</th>
                      <th>PTS</th>
                  </tr>
                   {standing.table.map((e) =>{
                          return(
                            <tr className="wpos" >
                            <td>{e.position}</td>
                            <td><img className="teamLogo" src={e.team.crestUrl}></img>  {e.team.name}</td>
                            <td>{e.playedGames}</td>
                            <td>{e.won}</td>
                            <td>{e.draw}</td>
                            <td>{e.lost}</td>
                            <td>{e.goalDifference}</td>
                            <td>{e.points}</td>
                            </tr>
                            
                          );
                      })} 
                </table>
                    :null;
        
                
                

            })}
             
            </div>
        );
    }
        
    
}

export default LaLigaStandings;