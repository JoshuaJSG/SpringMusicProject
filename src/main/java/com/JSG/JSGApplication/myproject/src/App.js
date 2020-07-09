import React, { useState, Component } from 'react';
import axios from "axios";
import styled, { ThemeProvider } from 'styled-components';
import './App.css';
import Button from './AppComponentCSS';


const stripStyle = {
    background: '#ADD8E6',
    padding: '1.5rem'
}

const emptySpace = {
    background: 'white',
    padding: '1rem'
}


const theme = {
    font: 'sans-serif'
}

const H1 = styled.h1`
    font-family: ${(props) => props.theme.font};
`

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
        document.title = "Artist Song Viewer"
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
            <ThemeProvider theme={theme}>
            <div className="App">

                
                <div style={stripStyle}>
                <H1>Artist Retrieval App</H1>
                <input type='Text' placeholder="Enter Artist Name" name="theArtistName" 
                    value={this.state.theArtistName}
                    onChange={this.handleArtistNameChange}>
                </input>
                <Button onClick={this.createArtist}>Add Artist</Button>
                
                </div>
                <div style ={emptySpace}></div>
                {this.state.artists.map(artist => <h4 key={artist.id}>{artist.name}
                <Button onClick={() =>this.deleteArtist(artist.id)}>Delete artist</Button></h4>)}
            </div>
            </ThemeProvider>
            </>
        )
        
    }

}


export default App;