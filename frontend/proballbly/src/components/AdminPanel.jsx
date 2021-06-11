import React, {createContext, useContext ,useEffect, useState}from "react";
import { useHistory } from "react-router-dom";
import axios from 'axios';
import { mixed } from "yup";
import "./css/AdminPanel.css"

const AdminPanel = () => {
    const history = useHistory();
    const [users, setUsers] = useState([]);
    const [userId, setUserId] = useState(null);
    const [teams, setTeams] = useState([]);
    const [teamId, setTeamId] = useState(null);

    
    useEffect(() => {

        fetch(`http://localhost:8080/api/users/`)
        .then((res) => res.json())
        .then((users)=>setUsers(users))
        console.log(users);
        
    },[]);

    useEffect(() => {
        fetch(`http://localhost:8080/api/teams/`)
        .then((res) => res.json())
        .then((teams)=>setTeams(teams))
        
    },[]);



    const deleteUser = (id) => {
        console.log("delete user");
        axios.delete(`http://localhost:8080/api/users/${id}`)
        .catch(res =>{
            console.error(res);
            alert("Deleting user failed");
            history.push('/');
        })

    }

    const deleteTeam = (id) => {
        console.log("delete team "+id);
        axios.delete(`http://localhost:8080/api/teams/${id}`)
        .catch(res =>{
            console.error(res);
            alert("Deleting team failed");
            history.push('/');
        })

    }

    function handleChange(e){
        setUserId(e.target.value);
    }

    const handleSubmitUser = (e) => {
        let id = userId;
        deleteUser(id);
        e.preventDefault();

        
    }

    const handleSubmitTeam = (e) => {
        deleteTeam(teamId);
        e.preventDefault();

        
    }



    return(
        <div className="selects">
            <form className="adminForm" onSubmit={handleSubmitUser}>
                <select className="minimal" id="1" value={userId} onChange={handleChange}>
                    {users.map((user) => {
                        return(
                            
                            <option key={user.id} value={user.id}>{user.id} {user.username} {user.roles[0]?user.roles[0].name:""} </option> 
                        );
                    })}
                
                </select>
                <div className="submitDiv">
                <p>Delete user by clicking a button below</p>
                <input className="submitInput" type="submit" value="Delete" />
                </div>
                </form>

                <form className="adminForm" onSubmit={handleSubmitTeam}>
                <select className="minimal" id="2" value={teamId}>
                    {teams.map((team) => {
                        return(
                            <option key={team.id} value={team.id}>{team.id} {team.name} from {team.city}</option> 
                        );
                    })}
                
                </select>
                <div className="submitDiv">
                <p>Delete team by clicking a button below</p>
                <input className="submitInput" type="submit" value="Delete" />
                </div>
                </form>
        </div>

    );
};
export default AdminPanel;