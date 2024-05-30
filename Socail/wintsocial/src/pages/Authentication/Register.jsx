import {  Button, FormControlLabel, Radio, RadioGroup, TextField } from '@mui/material';
import React, { useState } from 'react';
import * as Yup from "yup"
import { ErrorMessage, Form ,Formik ,Field } from 'formik';
import { LoginUserAction, RegisterUserAction } from '../../Redux/Auth/auth.action';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router';


const initialValues= { firstName : "" , lastName :"" , email:"" , password:"" ,gender:""};
const validationSchema = {
    email:Yup.string().email("Invalid Email").required("Email is requried"),
    password:Yup.string()
    .min(6, "Password must be 6 characters at least")
    .required("Password is required "),
};
const Register = () => {
    const [gender ,setGender ] = useState("");
    const dispatch = useDispatch();
    const navigate=useNavigate();
    
    const handleSubmit= (values) =>  {
        values.gender=gender;
        console.log("handle submit.......",values);
        dispatch(RegisterUserAction({data:values}));
    
    };

    const handleChange = (event) => {
        setGender(event.target.value);
    };
  return (
   <>
   <Formik 
    onSubmit={handleSubmit} 
   //.validationSchema ={validationSchema}
   initialValues={initialValues}>
     <Form className = "space-y-5">
        <div className="space-y-5">
        <div>
            <Field 
                as ={TextField}
                name ="firstName" 
                placeholder= "First Name"
                type ="text"
                variant ="outlined"
                fullWidth
                />
                <ErrorMessage
                name = "firstName"
                component ="div"
                className="text-red-500"
                />
            </div>  <div>
            <Field 
                as ={TextField}
                name ="lastName" 
                placeholder= "Last Name"
                type ="text"
                variant ="outlined"
                fullWidth
                />
                <ErrorMessage
                name = "lastName"
                component ="div"
                className="text-red-500"
                />
            </div>
            <div>
            <Field 
                as ={TextField}
                name ="email" 
                placeholder= "Email"
                type ="text"
                variant ="outlined"
                fullWidth
                />
                <ErrorMessage
                name = "mail"
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
            <div>
             <RadioGroup
         row
        aria-label="gender"
        name="gender"
      >
        <FormControlLabel onChange={handleChange} value="female" control={<Radio />} label="Female" />
        <FormControlLabel onChange={handleChange} value="male" control={<Radio />} label="Male" />
        <ErrorMessage
                name = "gender"
                component ="div"
                className="text-red-500"
                />
      </RadioGroup>
            </div>
        </div>
        <Button
         sx={{padding: ".8rem 0rem"}} 
         fullWidth type ="submit"
         variant= "contained"
        color="primary">
            Sign Up
      </Button>
     </Form>
   </Formik>

   <div className='flex gap-2 items-center justify-center pt-5'>
    <p>If you have already account </p>
    <Button onClick={()=>navigate("/login")}>Login</Button>
   </div>
</>
  );
}

export default Register;