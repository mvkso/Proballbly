import "./css/AllTeams.scss"
import React, {useState, useRef, useEffect} from "react";
import {Link} from "react-router-dom";
import { useHistory } from "react-router-dom";
import axios from "axios";


const AllTeams = () => {
    const history = useHistory();
    const [toggle, setToggle] = useState(true);
    const [teams, setTeams] = useState([]);
    const [search, setSearch] = useState(null);
   
    useEffect(() => {
        fetch(`http://localhost:8080/api/teams/`)
        .then((res) => res.json())
        .then((teams)=>setTeams(teams))
        
    },[]);

    const toggleTeams = () => {
        setToggle(!toggle)
      };

      const searchSpace=(event)=>{
        let keyword = event.target.value;
        setSearch(keyword)
      }
    
      const teamsItem = teams.filter((teams) => {
        if(search == null)
            return teams
            else if(teams.name.toString().toLowerCase().includes(search.toString().toLowerCase() 
            || teams.city.toString().toLowerCase().includes(search.toString().toLowerCase())))
            {
               
                return teams
            }
        
    }).map((teams)=> 
    <div className="teamCard" key={teams.id}>
                  <input type="checkbox" id={teams.id}/>
                  
                  <label for={teams.id}><img className="teamLogo" src={teams.logo}/>{teams.name} from {teams.city}</label>
                  <div className="content" id={teams.id}>
                    <div>{teams.description} <a href={teams.website}>{teams.website}</a></div>
                  </div>
                </div>

    )

    

      return(
          <section className="all-teams-section">
            
            <div className="links">
              <Link to="/addform">Add own team</Link>
              </div>
            <div className="inputdiv">
              <input type="text" placeholder="Find your team" onChange={(e)=>searchSpace(e)}></input>
            </div>

              {teamsItem}
        </section>
      );


}
export default AllTeams;
