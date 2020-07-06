import React, { useState, useEffect, useRef, Component } from 'react';
import axios from "axios";
import { Button } from 'reactstrap';

const api = axios.create({
    baseURL: "http://localhost:8080/artists"
});


class App extends Component{


    state = {
        artists: [],
        theArtistName: '',
      };

    constructor(props) {
        super(props);
        this.handleArtistNameChange = this.handleArtistNameChange.bind(this);
       
      }


    //calling this method will allow artist array to be populated everytime an event occurs, e.g POST, PUT, DELETE
    getArtists = async () =>{
        let data = await api.get("/").then(({ data }) => data);
        this.setState({artists: data}) //setting our artists to be the data we fetch
    }


    createArtist = async () =>{
        this.getArtists()
        if (!this.state.theArtistName == ""){
            let response = await api.post('/', {name: this.state.theArtistName})
            this.setState({theArtistName: ""})
        }return
    }


    deleteArtist = async (id) =>{
        let data = await api.delete('/${id}')
        this.getArtists();
    }

   
      

    //Once data is changed it is "Mounted" 
    componentDidMount(){
        this.createArtist()

    }

    componentWillUpdate(){
        this.getArtists()
    }
    //This is called everytime the textbox is updated
    handleArtistNameChange(event) {
        this.setState({ theArtistName: event.target.value });
      }

    render(){
        return(
            
            <>
                <input type='Text' placeholder="Enter Artist Name" 
                name="theArtistName" 
                value={this.state.theArtistName}
                onChange={this.handleArtistNameChange}></input>
                    <button onClick={this.createArtist}>Add Artist</button>
                
                        {this.state.artists.map(artist => <h4 key={artist.id}>{artist.name}
                    <button onClick={() =>this.deleteArtist(artist.id)}>Delete artist</button></h4>)}
            </>
        )
        
    }

}


export default App;