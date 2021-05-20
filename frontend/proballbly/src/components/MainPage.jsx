import React, {useState, useEffect} from "react";
import { Route, Switch, NavLink} from "react-router-dom";
import Standings from "./Standings";
import "./MainPage.css"

const MainPage = () => {

    const [competitions, setCompetitions] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/competitions")
        .then((res) => res.json())
        .then((data)=>setCompetitions(data))
    },[]);
    

    return(
        <section className = "main-page-grid">
            {competitions.map((competition)=> 
                <div className="competition-item" key={competition.id}>
                    <div class="competition-box">
                        <div className="diamond">
                            <span>{competition.name}</span>
                            <div className="competition-tip">{competition.area.name}</div>
                        </div>
                    </div>
                </div>
                

            )}

        </section>

    );

};
export default MainPage;