import { Button } from "@mui/material";
import GoogleIcon from '@mui/icons-material/Google';
import { GitHub } from "@mui/icons-material";
export default function Test(){
    return(
      <>
      <Button variant="outlined" startIcon={<GoogleIcon/>}>Google</Button> 
      <br />
      <br />

      <Button variant="outlined" startIcon={<GitHub/>}>Github</Button>
      </>
    )
}