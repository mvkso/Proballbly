import React from "react";
import "./Standings.css";


const Standings = (data) => {


    return(
        <div className="ptable">
              <h1 className="headin">STANDINGS</h1>
                {data.map((standing) =>{
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
                    :<h1>LOADING DATA</h1>;
        
                
                

            })}
             
            </div>
    );


};
export default Standings;
