import React, {useState, useEffect} from "react";
import { Route, Switch, NavLink, useHistory, Link} from "react-router-dom";
import Standings from "./Standings";
import "./MainPage.css"

const MainPage = () => {

    const history = useHistory();
    function handleClick(id){
        history.push("/:id",{params: id})
    }
    const [competitions, setCompetitions] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/competitions")
        .then((res) => res.json())
        .then((data)=>setCompetitions(data))
    },[]);
    

    return(
        <div className="body">
            <header className="main-header">
                <h1>WELCOME TO PROBALLBLY</h1>
                <h2>CHOOSE YOUR LEAGUE</h2>
            </header>
        <section className = "main-page-grid">
            {competitions.map((competition)=> 
            <NavLink to={'/standings/'+competition.id}>
                <div className="competition-item" key={competition.id}>
                    <div class="competition-box">
                        <div className="diamond">
                            <span>{competition.name}</span>
                            <div className="competition-tip">{competition.area.name}</div>
                        </div>
                    </div>
                </div>
                </NavLink>

            )}

        </section>
        </div>

    );

};
export default MainPage;