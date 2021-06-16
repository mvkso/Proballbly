import React, {useState, useEffect} from "react";
import { Route, Switch, NavLink, useHistory, Link} from "react-router-dom";
import Standings from "./Standings";
import "./css/MainPage.css";
import Pagination from "./Pagination";


const MainPage = ({loggedUser}) => {

    const history = useHistory();
    function handleClick(id){
        history.push("/:id",{params: id})
    }
    const [competitions, setCompetitions] = useState([]);
    const [search, setSearch] = useState(null);
    const [currentPage, setCurrentPage] = useState(1);
    const [competitionsPerPage] = useState(20);

    useEffect(() => {
        fetch("http://localhost:8080/competitions")
        .then((res) => res.json())
        .then((data)=>setCompetitions(data))
    },[]);

    const searchSpace=(event)=>{
        let keyword = event.target.value;
        setSearch(keyword)
      }

      //Get current competitions
    const indexOfLastCompetition = currentPage * competitionsPerPage;
    const indexOdFirstCompetition = indexOfLastCompetition - competitionsPerPage;
    const currentCompetitions = competitions.slice(indexOdFirstCompetition,indexOfLastCompetition);

    // Change page
  const paginate = pageNumber => setCurrentPage(pageNumber);

    
    const competitionItems = currentCompetitions.filter((competition) => {
        if(search == null)
            return competition
            else if(competition.name.toString().toLowerCase().includes(search.toString().toLowerCase() 
            || competition.area.name.toString().toLowerCase().includes(search.toString().toLowerCase())))
            {
                console.log(competition)
                return competition
            }
        
    }).map((competition)=> 
    <NavLink to={'/standings/'+competition.id}>
        <div className="competition-item" key={competition.id}>
            <div className="competition-box">
                <div className="diamond">
                    <span>{competition.name}</span>
                    <div className="competition-tip">{competition.area.name}</div>
                </div>
            </div>
        </div>
        </NavLink>

    )

    

    return(
        
        <div className="body">
            {loggedUser &&
            <header className="main-header">
                
                <h1>WELCOME TO PROBALLBLY</h1>
                <h2>CHOOSE YOUR LEAGUE</h2>
                <Pagination competitionsPerPage={competitionsPerPage} totalCompetitions={competitions.length} paginate={paginate}/>
                <input type="text" placeholder="Find your league" onChange={(e)=>searchSpace(e)}></input>
                
            </header>
}         
{
            !loggedUser &&
            <header className="main-header">
                <h1>SIGN UP TO SEE OUR CONTENT</h1>
                <h2>Cheers</h2>
            </header>
        }
        { loggedUser &&
        
        <section className = "main-page-grid">
            
            {/* {competitions.map((competition)=> 
            <NavLink to={'/standings/'+competition.id}>
                <div className="competition-item" key={competition.id}>
                    <div className="competition-box">
                        <div className="diamond">
                            <span>{competition.name}</span>
                            <div className="competition-tip">{competition.area.name}</div>
                        </div>
                    </div>
                </div>
                </NavLink>

            )} */}
            {competitionItems}
            
      
        </section>
        
}
        
        
        </div>
            

    );

};
export default MainPage;