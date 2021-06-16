import { render } from '@testing-library/react';
import React, {Component} from 'react';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import MainPage from "./components/MainPage";
import Header from "./components/Header"
import Nav from "./components/Navigation"
import BplStandings from "./components/BplStandings"
import "./App.css"
import LaLigaStandings from './components/LaLigaStandings';
import BundesligaStandings from './components/BundesligaStandings';
import Ligue1Standings from './components/Ligue1Standings';
import Standings from "./components/Standings";
import Signup from "./components/Signup";
import AllTeams from "./components/AllTeams";
import AddTeam from "./components/addTeam";
import Authentication from "./scripts/authentication";
import {useEffect, useState} from "react";
import AdminPanel from './components/AdminPanel';
import Footer from './components/Footer';

function App(){  

  const [loggedUser, setLoggedUser] = useState(null);

  useEffect(() => {
      setLoggedUser(Authentication.getCurrentUser());
  }, []);

    return (
      <BrowserRouter>
          <div className="App">     
          <Header loggedUser={loggedUser} setLoggedUser={setLoggedUser}/>
            <Nav loggedUser={loggedUser}/>  
          <div className="base-container">
          <Switch>
            <Route exact path="/">
                <MainPage loggedUser={loggedUser}/>
            </Route>
            <Route exact path="/bpl">
              <BplStandings loggedUser={loggedUser}/>
            </Route>
            <Route exact path="/laliga">
              <LaLigaStandings loggedUser={loggedUser}/>
            </Route>
            <Route exact path="/bundesliga">
              <BundesligaStandings loggedUser={loggedUser}/>
            </Route>
            <Route exact path="/ligue1">
              <Ligue1Standings loggedUser={loggedUser}/>
            </Route>
            <Route exact path='/standings/:id' component={Standings} loggedUser={loggedUser}/>
            <Route exact path='/login'
            render={(props) => <Signup {...props} setLoggedUser={setLoggedUser}/>}
            >
            </Route>
            <Route exact path='/allteams'>
              <AllTeams/>
            </Route>
            <Route exact path='/addform'>
              <AddTeam/>
            </Route>
            <Route exact path='/adminPanel'>
              <AdminPanel/>
            </Route>
              
          </Switch>
         
          </div>
          
          <Footer/>
      </div>
      
        
      
      </BrowserRouter>
      
    );


}

export default App;