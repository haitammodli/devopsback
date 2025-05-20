package org.sid.ada_backendv.mappers;

import org.sid.ada_backendv.dtos.*;
import org.sid.ada_backendv.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MessageMapperImpl {


    public DoctorDTO fromDoctor(Doctor doctor){
        DoctorDTO doctorDTO=new DoctorDTO();
        BeanUtils.copyProperties(doctor,doctorDTO);
        return  doctorDTO;
    }
    public Doctor fromDoctorDTO(DoctorDTO doctorDTO) {
        Doctor doctor=new Doctor();
        BeanUtils.copyProperties(doctorDTO,doctor);
        return  doctor;
    }

    public PatientDTO fromPatient(Patient patient) {
        PatientDTO patientDTO=new PatientDTO();
        BeanUtils.copyProperties(patient,patientDTO);
        return  patientDTO;
    }

    public Patient fromPatientDTO(PatientDTO patientDTO) {
        Patient patient=new Patient();
        BeanUtils.copyProperties(patientDTO,patient);
        return  patient;
    }

    public AdminDTO fromAdmin(Admin admin) {
        AdminDTO adminDTO=new AdminDTO();
        BeanUtils.copyProperties(admin,adminDTO);
        return  adminDTO;
    }

    public Admin fromAdminDTO(AdminDTO adminDTO) {
        Admin admin=new Admin();
        BeanUtils.copyProperties(adminDTO,admin);
        return  admin;
    }

}
