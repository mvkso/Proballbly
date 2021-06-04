import React, {useState, useRef} from "react";
import { useHistory } from "react-router-dom";
import axios from "axios";
import "./css/addTeam.css"



const AddTeam = () => {
    const history = useHistory();
    const API_URL = "http://localhost:8080/api/teams/";

    const [name,setName] = useState("");
    const [shortName, setShortName] = useState("");
    const [website, setWebsite] = useState("");
    const [description, setDescription] = useState("");
    const [city, setCity] = useState("");
    const [logo, setLogo] = useState("");
    const [arena, setArena] = useState("");
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");
    
    const onClickButton = () => {
        history.push("/allteams");
    }

    const addTeams = (name,
        shortName,
        website,
        description,
        city,
        logo,
        arena) =>{
        return axios.post(API_URL, {
            name,
            shortName,
            website,
            description,
            city,
            logo,
            arena,
        });
    };

    const handleAddTeam = () => {
        addTeams(name,
            shortName,
            website,
            description,
            city,
            logo,
            arena).then(
            (response) => {
              setMessage(response.data.message);
              setSuccessful(true);
              alert("Success!");
              history.push("/allteams");
              window.location.reload();
            },
            (error) => {
              const resMessage =
                (error.response &&
                  error.response.data &&
                  error.response.data.message) ||
                error.message ||
                error.toString();
                alert("Adding team error, let's go back to main page");
                history.push('/');
              setMessage(resMessage);
              setSuccessful(false);
            }
          );
    };

    const onChangeName = (e) => {
        const name = e.target.value;
        setName(name);
      };

      const onChangeShortName = (e) => {
        const shortName = e.target.value;
        setShortName(shortName);
      };

      const onChangeWebsite = (e) => {
        const website = e.target.value;
        setWebsite(website);
      };

      const onChangeDescription = (e) => {
        const description = e.target.value;
        setDescription(description);
      };

      const onChangeCity = (e) => {
        const city = e.target.value;
        setCity(city);
      };

      const onChangeLogo= (e) => {
        const logo = e.target.value;
        setLogo(logo);
      };

      const onChangeArena = (e) => { 
        const arena = e.target.value;
        setArena(arena);
      };

    return(
        <section className="formSection">
            <div className="form-login">
                <form class="team-form" onSubmit={handleAddTeam}>
      <input id='name' type="name" name="text" placeholder="type name" onChange={onChangeName} value={name}/>
      <input id='shortName' type="text" name="shortName" placeholder="type short name" onChange={onChangeShortName} value={shortName}/>
      <input id='website' type="url" name="website" placeholder="type website url" onChange={onChangeWebsite} value={website}/>
      <input id='city' type="text" name="city" placeholder="type city" onChange={onChangeCity} value={city}/>
      <input id='logo' type="url" name="logo" placeholder="type logo url" onChange={onChangeLogo} value={logo}/>
      <input id='arena' type="text" name="arena" placeholder="type arena" onChange={onChangeArena} value={arena}/>
      <input id='description' type="text" name="description" placeholder="type description" onChange={onChangeDescription} value={description}/>
      <button type='submit'>Add team</button>
      <p class="message" >Not interested? <a onClick={onClickButton}>Check other teams</a></p>
        </form>
        </div>
        </section>
    );

}
export default AddTeam;