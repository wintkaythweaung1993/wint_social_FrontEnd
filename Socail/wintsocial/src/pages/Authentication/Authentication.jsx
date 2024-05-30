import { Card, Grid } from '@mui/material'
import React from 'react'
import Login from './Login'
import Register from './Register'
import {Routes,Route} from 'react-router-dom'


const Authentication = () => {
  return (
    <div>
      <Grid container>
        <Grid className ='h-screen overflow-hidden' item xs ={7}>
            <img className= 'h-full w-full'src ="https://previews.123rf.com/images/cteconsulting/cteconsulting0906/cteconsulting090600129/4967841-social-network-diagram-chart-representing-a-network-of-people-communicating-with-each-other.jpg" />
        </Grid>
        <Grid item xs ={5}>
            <div className='px-20 flex-col justify-center h-full'>
                <div className='card p-8'>
                    <div className='flex flex-col items-center mb-5 space-y-1'>
                    <h1 className='logo text-center'>W!nt Soc!al </h1>
                    <p className='text-center text-sm w-[70&]'> Connecting Lives,Sharing stories : Your Social World ,Your way ! </p>

                    </div>
              <Routes>
                <Route path='/' element={<Login/>}></Route>
                
                <Route path='/login' element={<Login/>}></Route>

                <Route path='/register' element={<Register/>}></Route>


              </Routes>
                    
                 
                  
                 
                    
                </div>
            </div>
            
        </Grid>
    </Grid>
    </div>
  )
}

export default Authentication

