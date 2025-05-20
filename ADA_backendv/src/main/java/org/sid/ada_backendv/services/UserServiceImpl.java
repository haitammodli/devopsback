package org.sid.ada_backendv.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.ada_backendv.dtos.*;
import org.sid.ada_backendv.entities.*;
import org.sid.ada_backendv.enums.Role;
import org.sid.ada_backendv.exceptions.UserNotFoundException;
import org.sid.ada_backendv.mappers.MessageMapperImpl;
import org.sid.ada_backendv.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final AdminRepository adminRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final MessageMapperImpl messageMapperImpl;

    @Override
    public AdminDTO saveAdmin(AdminDTO adminDTO) {
        log.info("Saving new Admin");
        Admin admin = messageMapperImpl.fromAdminDTO(adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        return messageMapperImpl.fromAdmin(savedAdmin);
    }

    @Override
    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
        log.info("Saving new Doctor");
        Doctor doctor = messageMapperImpl.fromDoctorDTO(doctorDTO);
        doctor.setRole(Role.DOCTOR); // Set the enum
        Doctor savedDoctor = doctorRepository.save(doctor);
        return messageMapperImpl.fromDoctor(savedDoctor);
    }

    @Override
    public PatientDTO savePatient(PatientDTO patientDTO) {
        log.info("Saving new Patient");
        Patient patient = messageMapperImpl.fromPatientDTO(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return messageMapperImpl.fromPatient(savedPatient);
    }

    @Override
    public List<AdminDTO> listAdmins() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminDTO> adminDTOS = admins.stream()
                .map(admin -> messageMapperImpl.fromAdmin(admin))
                .collect(Collectors.toList());

        return adminDTOS;
    }

    @Override
    public List<DoctorDTO> listDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDTO> doctorDTOS = doctors.stream()
                .map(doctor -> messageMapperImpl.fromDoctor(doctor))
                .collect(Collectors.toList());

        return doctorDTOS;
    }

    @Override
    public List<PatientDTO> listPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDTO> patientDTOS = patients.stream()
                .map(patient -> messageMapperImpl.fromPatient(patient))
                .collect(Collectors.toList());

        return patientDTOS;
    }

    @Override
    public AdminDTO getAdmin(Long adminId) throws UserNotFoundException {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new UserNotFoundException("admin Not found"));
        return messageMapperImpl.fromAdmin(admin);
    }

    @Override
    public DoctorDTO getDoctor(Long doctorId) throws UserNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new UserNotFoundException("Doctor Not Found"));
        return messageMapperImpl.fromDoctor(doctor);
    }

    @Override
    public PatientDTO getPatient(Long patientId) throws UserNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new UserNotFoundException("Patient Not Found"));
        return messageMapperImpl.fromPatient(patient);
    }

    @Override
    public AdminDTO updateAdmin(AdminDTO adminDTO) {
        log.info("Updating Admin");
        Admin admin = messageMapperImpl.fromAdminDTO(adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        return messageMapperImpl.fromAdmin(savedAdmin);
    }
    @Override
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO) {
        log.info("Updating Doctor");
        Doctor doctor = messageMapperImpl.fromDoctorDTO(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return messageMapperImpl.fromDoctor(savedDoctor);
    }
    @Override
    public PatientDTO updatePatient(PatientDTO patientDTO) {
        log.info("Updating Patient");
        Patient patient = messageMapperImpl.fromPatientDTO(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return messageMapperImpl.fromPatient(savedPatient);
    }
    @Override
    public void deletePatient(Long patientId){
        patientRepository.deleteById(patientId);
    }
    @Override
    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
    }
    @Override
    public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
    @Override
    public List<AdminDTO> searchAdmins(String keyword) {
        List<Admin> admins=adminRepository.searchAdmin(keyword);
        List<AdminDTO> adminDTOS = admins.stream().map(cust -> messageMapperImpl.fromAdmin(cust)).collect(Collectors.toList());
        return adminDTOS;
    }
    @Override
    public List<PatientDTO> searchPatients(String keyword) {
        List<Patient> patients=patientRepository.searchPatient(keyword);
        List<PatientDTO> patientDTOS = patients.stream().map(cust -> messageMapperImpl.fromPatient(cust)).collect(Collectors.toList());
        return patientDTOS;
    }
    @Override
    public List<DoctorDTO> searchDoctors(String keyword) {
        List<Doctor> doctors=doctorRepository.searchDoctor(keyword);
        List<DoctorDTO> doctorDTOS = doctors.stream().map(cust -> messageMapperImpl.fromDoctor(cust)).collect(Collectors.toList());
        return doctorDTOS;
    }
}

