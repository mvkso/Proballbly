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

function App(){  
    return (
      <BrowserRouter>
          <div className="App">     
            <Header/>
            <Nav/>  
          <div className="base-container">
          <Switch>
            <Route exact path="/">
                <MainPage/>
            </Route>
            <Route exact path="/bpl">
              <BplStandings/>
            </Route>
            <Route exact path="/laliga">
              <LaLigaStandings/>
            </Route>
            <Route exact path="/bundesliga">
              <BundesligaStandings/>
            </Route>
            <Route exact path="/ligue1">
              <Ligue1Standings/>
            </Route>
            <Route exact path='/standings/:id' component={Standings}/>
          </Switch>
          </div>
      </div>
      </BrowserRouter>
    );


}

export default App;