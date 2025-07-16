import { useState } from 'react'   
import './index.css'
import { Box, Container,Button,MenuItem, Select,InputLabel,FormControl, Typography ,TextField, CircularProgress} from '@mui/material';
import axios from 'axios';

function App() {
    
  const [emailContent , setEmailContent] = useState('');
  const [tone , setTone] = useState('');
  const [generatedReply , setGeneratedReply] = useState('');
  const [loading ,setloading] = useState(false);
  const [error,seterror] = useState('');
  const handleSubmit = async () =>{
    // since it's loading
     setloading(true);
     // for fresh errors
     seterror('');
     try{
    const response = await axios.post("http://localhost:8080/api/email/generate",{
      emailContent,
      tone
    });
    setGeneratedReply(typeof response.data ==='string' ? response.data : JSON.stringify(response.data));
     } catch(error){
         seterror('Failed to generate email reply , Please try again');
         console.error(error);

     }
     finally{
      //??
      setloading(false);
     }
  }
  return(
    <>
    <Container maxWidth="md" sx={{py:4}}>
      <Typography variant='h3' component="h1" gutterBottom> Email Reply Generator</Typography>
      <Box sx={{mx:3}}>
        <TextField fullWidth multiline rows={6} variant='outlined' label="Original Email Content" value={emailContent || '' } onChange={(e) =>setEmailContent(e.target.value)  } />
     
     
      <FormControl  sx={{mt:5 ,width:250}}>
        <InputLabel>Tone (optional)</InputLabel>
        <Select value={tone || '' } 
        label={"Tone (optional)"}
        onChange={(e) => setTone(e.target.value)}>
          <MenuItem value="">None</MenuItem>
          <MenuItem value="professional">Profesional</MenuItem>
          <MenuItem value="funny">Funny</MenuItem>
          <MenuItem value="annoying">Annoying</MenuItem>

        </Select>
      </FormControl>
       <Button
       variant='contained'
      onClick={handleSubmit}
      sx={{mt:15,height:50,width:250}}
          disabled={!emailContent || loading}
      >
       {loading ? <CircularProgress     size={25}/> :  "Generate Reply" }

       </Button>

 </Box>    
{/* why error ?
  as per the code, it should be set when there is an error in the API call, but it is not being set anywhere in the provided code.

*/}

 { error && (
   <Typography color="error" sx={{mt:2}}>
     {error}
   </Typography>)}

    { generatedReply && (
        <Box sx={{ mt :3}}>
          <Typography variant='h6' gutterBottom>
            Generated Reply:
          </Typography>
         <TextField
         fullWidth
         multiline
         rows={6}
         variant='outlined'
         value={generatedReply || ''}
         inputProps={{readOnly: true}}/>
         <Button 
         variant='outlined'
         sx={{mt:2}}
         onClick={() => navigator.clipboard.writeText(generatedReply)}
         >
          Copy to Clipboard
         </Button>

        </Box>

    )}


    </Container>
    </>
  )
  
}

export default App


