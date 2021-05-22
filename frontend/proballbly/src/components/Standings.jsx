import React, {useState, useEffect} from "react";
import { useHistory, useParams } from "react-router";
import { NavLink } from "react-router-dom";
import Select from "./Select";
import "./Standings.css";


const Standings = () => {
    const history = useHistory();
    const {id} = useParams();
    const [data, setData] = useState([]);

    function handleClick(){
        history.push('/allteams');
    }

    useEffect(() => {
        fetch(`http://localhost:8080/competitions/${id}/standings`)
        .then((res) => res.json())
        .then((data)=>setData(data))
        
    },[]);




    return(
        <div className="ptable">
                {data.map((standing) =>{
                  return standing.type === "TOTAL"?
                  <div className="standing-div"> 
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
                            <tr className="wpos" onClick={() => handleClick()} >
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
                </div>
                    :null;
        
                
                

            })}
            
            <Select data={data}/>
            </div>
    );


};
export default Standings;
