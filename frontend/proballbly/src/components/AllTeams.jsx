import "./css/AllTeams.scss"
import React, {useState, useRef, useEffect} from "react";
import {Link} from "react-router-dom";
import { useHistory } from "react-router-dom";
import axios from "axios";


const AllTeams = () => {
    const history = useHistory();
    const API_URL = "http://localhost:8080/api/teams/";
    const [toggle, setToggle] = useState(true);
    const [teams, setTeams] = useState([]);
    const [name,setName] = useState("");
    const [shortName, setShortName] = useState("");
    const [website, setWebsite] = useState("");
    const [description, setDescription] = useState("");
    const [city, setCity] = useState("");
    const [logo, setLogo] = useState("");
    const [arena, setArena] = useState("");
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");
   
    useEffect(() => {
        fetch(`http://localhost:8080/api/teams/`)
        .then((res) => res.json())
        .then((teams)=>setTeams(teams))
        
    },[]);

    const toggleTeams = () => {
        setToggle(!toggle)
        //history.push("/allteams");
      };


    

      return(
          <section className="all-teams-section">
            
            <div className="links">
              <Link to="/addform">Add own team</Link>
              </div>
            
            {teams.map((team) => {
              return(
                <div className="teamCard" key={team.id}>
                  <input type="checkbox" id={team.id}/>
                  
                  <label for={team.id}><img className="teamLogo" src={team.logo}/>{team.name} from {team.city}</label>
                  <div className="content" id={team.id}>
                    <div>{team.description} <a href={team.website}>{team.website}</a></div>
                  </div>
                </div>
              );
            })}
        </section>
      );


}
export default AllTeams;
