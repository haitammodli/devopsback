package org.sid.ada_backendv.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.ada_backendv.dtos.AdminDTO;
import org.sid.ada_backendv.dtos.DoctorDTO;
import org.sid.ada_backendv.dtos.PatientDTO;
import org.sid.ada_backendv.entities.Admin;
import org.sid.ada_backendv.exceptions.UserNotFoundException;
import org.sid.ada_backendv.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("http://localhost:5173")

public class UserRestController {
    private UserService userService;
    @GetMapping("/admins")
    public List<AdminDTO> admin(){
        return userService.listAdmins();
    }
    @GetMapping("/patients")
    public List<PatientDTO> patient(){
        return userService.listPatients();
    }
    @GetMapping("/doctors")
    public List<DoctorDTO> doctor(){
        return userService.listDoctors();
    }
    @GetMapping("/admins/search")
    public List<AdminDTO> searchAdmins(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return userService.searchAdmins("%"+keyword+"%");
    }
    @GetMapping("/patients/search")
    public List<PatientDTO> searchPatients(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return userService.searchPatients("%"+keyword+"%");
    }
    @GetMapping("/doctor/search")
    public List<DoctorDTO> searchDoctors(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return userService.searchDoctors("%"+keyword+"%");
    }
    @GetMapping("/admins/{id}")
    public AdminDTO getAdmin(@PathVariable(name = "id") Long adminId) throws UserNotFoundException {
        return userService.getAdmin(adminId);
    }
    @GetMapping("/patients/{id}")
    public PatientDTO getPatient(@PathVariable(name = "id") Long patientId) throws UserNotFoundException {
        return userService.getPatient(patientId);
    }
    @GetMapping("/doctors/{id}")
    public DoctorDTO getDoctor(@PathVariable(name = "id") Long doctorId) throws UserNotFoundException {
        return userService.getDoctor(doctorId);
    }
    @PostMapping("/admins")
    public AdminDTO saveAdmin(@RequestBody AdminDTO adminDTO){
        return userService.saveAdmin(adminDTO);
    }
    @PostMapping("/patients")
    public PatientDTO savePatient(@RequestBody PatientDTO patientDTO){
        return userService.savePatient(patientDTO);
    }
    @PostMapping("/doctors")
    public DoctorDTO saveDoctor(@RequestBody DoctorDTO doctorDTO){
        return userService.saveDoctor(doctorDTO);
    }
    @PutMapping("/admins/{adminId}")
    public AdminDTO updateAdmin(@PathVariable Long adminId, @RequestBody AdminDTO adminDTO){
        adminDTO.setId(adminId);
        return userService.updateAdmin(adminDTO);
    }
    @PutMapping("/patients/{patientId}")
    public PatientDTO updatePatient(@PathVariable Long patientId, @RequestBody PatientDTO patientDTO){
        patientDTO.setId(patientId);
        return userService.updatePatient(patientDTO);
    }
    @PutMapping("/doctors/{doctorId}")
    public DoctorDTO updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDTO doctorDTO){
        doctorDTO.setId(doctorId);
        return userService.updateDoctor(doctorDTO);
    }
    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable Long id){
        userService.deleteAdmin(id);
    }
    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable Long id){
        userService.deletePatient(id);
    }
    @DeleteMapping("/doctor/{id}")
    public void deleteDoctor(@PathVariable Long id){
        userService.deleteDoctor(id);
    }
}
