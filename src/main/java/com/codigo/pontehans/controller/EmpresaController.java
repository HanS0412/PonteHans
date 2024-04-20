package com.codigo.pontehans.controller;

import com.codigo.pontehans.dto.EmpresaDTO;
import com.codigo.pontehans.request.EmpresaRequest;
import com.codigo.pontehans.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "Api de Empresas",
        description = "Esta api te permite realizar CRUDS de Empresas"
)
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping("/crearEmpresa")
    @Operation(
            summary = "Guardar una Empresa en base de datos",
            description = "Para usar endPoint debes enviar una objeto Empresa, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "RequestBody", description = "objeto Empresa")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTTP STATUS 201 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST Fallo",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaDTO> crear(@RequestBody EmpresaRequest empresaRequest){
        EmpresaDTO empresa = empresaService.crearEmpresa(empresaRequest);
        return new ResponseEntity<>(empresa, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar una Empresa por ID en base de datos",
            description = "Para usar endPoint debes enviar un ID",
            parameters = {
                    @Parameter(name = "PathVariable", description = "Long id")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa registro encontrado de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTTP STATUS 404 significa que el registro no fue encontrado",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST Fallo",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<Optional<EmpresaDTO>> obtener(@PathVariable Long id){
        Optional<EmpresaDTO> empresa = empresaService.obtenerEmpresa(id);
        if (empresa.isPresent()){
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/obtenerTodos")
    @Operation(
            summary = "Buscar todas las Empresas en base de datos",
            description = "Muestra todas las empresas existentes"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa registro encontrado de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "HTTTP STATUS 204 significa que no existen empresas registradas",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST Fallo",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<List<EmpresaDTO>> obtenerTodos(){
        List<EmpresaDTO> empresas = empresaService.obtenerEmpresas();
        if (!Objects.isNull(empresas)){
            return new ResponseEntity<>(empresas, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modificarEmpresa/{id}")
    @Operation(
            summary = "Modificar una Empresa en base de datos",
            description = "Para usar endPoint debes enviar un ID y un objeto Empresa, la cual se actualizará en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "1.PathVariable", description = "Long ID"),
                    @Parameter(name = "2.RequestBody", description = "objeto Empresa")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa modificacion exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST Fallo",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaDTO> modificar(@PathVariable Long id,@RequestBody EmpresaRequest empresaRequest){
        EmpresaDTO empresa = empresaService.actualizarEmpresa(id,empresaRequest);
        if(!Objects.isNull(empresa)){
            return new ResponseEntity<>(empresa, HttpStatus.OK
            );
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eliminarEmpresa/{id}")
    @Operation(
            summary = "Eliminar una Empresa en base de datos",
            description = "Para usar endPoint debes enviar un ID, el eliminado es Lógico",
            parameters = {
                    @Parameter(name = "ID -> PathVariable", description = "Long ID")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa eliminación lógica exitoso",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST Fallo",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaDTO> eliminar(@PathVariable Long id){
        EmpresaDTO empresa = empresaService.deleteEmpresa(id);
        if(!Objects.isNull(empresa)){
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


}
