import styled from 'styled-components';


export default styled.button`
    font-family: ${(props) => props.theme.font};
    font-size: 1.3rem;
    border: none;
    border-radius: 30px;
    padding: 7px 10px;
    background: #00BCD4;
    margin: 0 10px;
    color: black;

    &:hover {
        background: #2196F3
    }
`
