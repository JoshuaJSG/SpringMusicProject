import React, { useState, Component } from 'react';
import axios from "axios";
import styled, { ThemeProvider } from 'styled-components';
import './App.css';
import Logo from './Logo';
import Button from './AppComponentCSS';
import { func } from 'prop-types';


const stripStyle = {
    background: '#192a56',
    padding: '1.5rem'
}

const artistStrip = {
    background: '#40739e',
    padding: '1.5rem',


}

function createEmptyLine() {
    const emptySpace = {
        background: 'white',
        padding: '0.5rem'
    }
}

//adding a space after the header backround
const emptySpace = {
    background: 'white',
    padding: '0.1rem'
}


const theme = {
    font: 'sans-serif'
}

const H1 = styled.h1`
    font-family: ${(props) => props.theme.font};
    color: white;
`

//Style 1

const S1 = styled.h5`
    font-family: ${(props) => props.theme.font};
    color: white;
`

const api = axios.create({
    baseURL: "http://localhost:8080/artists/"
});


const logo = document.querySelectorAll("#logo path");

for (let i = 0; i < logo.length; i++) {
    console.log(`Letter ${i} is ${logo[i].getTotalLength()}`);
}


class App extends Component {


    state = {
        artists: [],
        theArtistName: '',
        id: '',
    };

    constructor(props) {
        super(props);
        this.handleArtistNameChange = this.handleArtistNameChange.bind(this);

    }


    //calling this method will allow artist array to be populated everytime an event occurs, e.g POST, PUT, DELETE
    getArtists = async () => {
        let data = await api.get("/").then(({ data }) => data);
        this.setState({ artists: data }) //setting our artists to be the data we fetch
    }


    createArtist = async () => {
        this.getArtists()
        if (!this.state.theArtistName == "") {
            let response = await api.post('/', { name: this.state.theArtistName })
            this.setState({ theArtistName: "" })
        } return
    }


    deleteArtist = async (id) => {
        let data = await api.delete('/${id}')
        this.getArtists();
    }


    deleteArtistById() {
        {
            if (window.confirm('Are you sure you want to delete this field')) {
                axios.delete("http://localhost:8080/artists/6")
                .catch(err => console.error(err));
            }
        }

    }



    //Once data is changed it is "Mounted" 
    componentDidMount() {
        document.title = "Artist Song Viewer"
        this.createArtist()

    }

    componentWillUpdate() {
        this.getArtists()
    }
    //This is called everytime the textbox is updated
    handleArtistNameChange(event) {
        this.setState({ theArtistName: event.target.value });
    }



    render() {
        return (
            <>

                <ThemeProvider theme={theme}>
                    <Logo />
                    <div className="App">
                        <div style={stripStyle}>
                            <H1>Artist Retrieval App</H1>
                            <input type='Text' placeholder="Enter Artist Name" name="theArtistName"
                                value={this.state.theArtistName}
                                onChange={this.handleArtistNameChange}>
                            </input>
                            <Button onClick={this.createArtist}>Add Artist</Button>
                        </div>
                        <div style={emptySpace}></div>
                    </div>
                    <div style={artistStrip}>
                        {this.state.artists.map(artist => <S1 key={artist.id}><H1>Artist Name: {artist.name}</H1>
                            <S1><div>Songs: {artist.songs}</div></S1>
                            <H1>{artist.id}</H1>
                            <Button onClick={() => this.deleteArtistById()}> Delete Artist</Button></S1>)}
                    </div>
                </ThemeProvider>
            </>
        )

    }

}




export default App;