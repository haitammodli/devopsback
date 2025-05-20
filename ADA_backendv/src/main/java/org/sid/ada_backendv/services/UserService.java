package org.sid.ada_backendv.services;

import org.sid.ada_backendv.dtos.AdminDTO;
import org.sid.ada_backendv.dtos.UserDTO;
import org.sid.ada_backendv.dtos.DoctorDTO;
import org.sid.ada_backendv.dtos.PatientDTO;
import org.sid.ada_backendv.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    AdminDTO saveAdmin(AdminDTO adminDTO);
    DoctorDTO saveDoctor(DoctorDTO doctorDTO);
    PatientDTO savePatient(PatientDTO patientDTO);

    List<AdminDTO> listAdmins();
    List<DoctorDTO> listDoctors();
    List<PatientDTO> listPatients();

    AdminDTO getAdmin(Long userId) throws UserNotFoundException;
    DoctorDTO getDoctor(Long doctorId) throws UserNotFoundException;
    PatientDTO getPatient(Long patientId) throws UserNotFoundException;

    AdminDTO updateAdmin(AdminDTO adminDTO);
    void deleteAdmin(Long adminId);
    PatientDTO updatePatient(PatientDTO patientDTO);
    void deletePatient(Long patientId);
    DoctorDTO updateDoctor(DoctorDTO doctorDTO);
    void deleteDoctor(Long doctorId);

    List<AdminDTO> searchAdmins(String keyword);
    List<PatientDTO> searchPatients(String keyword);
    List<DoctorDTO> searchDoctors(String keyword);
}
