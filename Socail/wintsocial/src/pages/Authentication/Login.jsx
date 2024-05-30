import {  Button, TextField } from '@mui/material';
import React, { useState } from 'react';
import * as Yup from "yup"
import { ErrorMessage, Form ,Formik ,Field } from 'formik';
import { LoginUserAction } from '../../Redux/Auth/auth.action';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router';

const initialValues= { email:"" , password:""};
const validationSchema = {
    email:Yup.string().email("Invalid Email").required("Email is requried"),
password:Yup.string().min(6, "Password must be 6 characters at least").required("Password is required "),
};
const Login = () => {
    const [formValue , setFormValue ] = useState();
    const dispatch = useDispatch();
    const navigate=useNavigate();


    const handleSubmit = (values) => {
        console.log("handle submit", values);
        dispatch(LoginUserAction({data:values}))
    };

  return (
   <>   <Formik 
    onSubmit={handleSubmit} 
   //.validationSchema ={validationSchema}
   initialValues={initialValues}>
     <Form className = "space-y-5">
        <div className="space-y-5">
            <div>
            <Field 
                as ={TextField}
                name ="email" 
                placeholder= "Email"
                type ="email"
                variant ="outlined"
                fullWidth
                />
                <ErrorMessage
                name = "email"
                component ="div"
                className="text-red-500"
                />
            </div>
            <div>
            <Field 
                as ={TextField}
                name ="password" 
                placeholder= "password"
                type ="password"
                variant ="outlined"
                fullWidth
                />
                <ErrorMessage
                name = "password"
                component ="div"
                className="text-red-500"
                />
            </div>
        </div>
       <Button sx={{padding: ".8rem 0rem"}} fullWidth type ="submit"
         variant= "contained" color="primary">Log In</Button>
     </Form>
   </Formik>
   <div className='flex gap-2 items-center justify-center pt-5'>
    <p>If you don't have account ? </p>
    <Button onClick={()=>navigate("/register")}>Register</Button>
   </div>
   </>

  );
}

export default Login